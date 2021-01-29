package ru.alfa.test.core.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ru.alfa.test.core.domain.dto.StorageContainer;
import ru.alfa.test.core.domain.dto.XmlFileContainer;
import ru.alfa.test.core.domain.entity.Box;
import ru.alfa.test.core.domain.entity.Item;
import ru.alfa.test.core.domain.exception.BoxValidationException;
import ru.alfa.test.core.domain.exception.ItemValidationException;
import ru.alfa.test.core.mapper.BoxMapper;
import ru.alfa.test.core.mapper.ItemMapper;
import ru.alfa.test.core.repository.BoxRepository;
import ru.alfa.test.core.repository.ItemRepository;

import generated.Storage;
import lombok.RequiredArgsConstructor;

/**
 * @author Vyacheslav Savinov
 * @since 28.01.2021
 */
@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {

    private final BoxRepository boxRepository;
    private final ItemRepository itemRepository;
    private final StorageContainer storageContainer;
    private final ItemMapper itemMapper;
    private final BoxMapper boxMapper;

    private Map<Integer, Box> boxMap;
    private Map<Integer, Item> itemMap;

    @PostConstruct
    public void init() {
        boxMap = storageContainer.getBoxMap();
        itemMap = storageContainer.getItemMap();
    }

    @Override
    public Storage parse(final XmlFileContainer xmlFileContainer) throws JAXBException {
        final String xmlBody = xmlFileContainer.getBody();
        final InputStream inputStream = new ByteArrayInputStream(xmlBody.getBytes());

        final JAXBContext jaxbContext = JAXBContext.newInstance(Storage.class);
        final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Storage) jaxbUnmarshaller.unmarshal(inputStream);
    }

    @Override
    public void handle(final Storage storage) {

        final List<generated.Box> externalBox = storage.getBox();
        final List<generated.Item> externalItem = storage.getItem();

        handleItems(Box.EXTERNAL_BOX, externalItem);
        handleBoxes(Box.EXTERNAL_BOX, externalBox);

        boxRepository.saveAll(boxMap.values());
        itemRepository.saveAll(itemMap.values());
    }

    private void handleBoxes(final Box externalBox, final List<generated.Box> boxes) {
        boxes.forEach(boxDto -> {
            if (boxMap.containsKey(boxDto.getId())) {
                throw new BoxValidationException(boxDto.getId());
            }

            final Box box = boxMapper.toEntity(boxDto);
            box.setContainedIn(externalBox.getId());
            boxMap.put(box.getId(), box);

            if (!CollectionUtils.isEmpty(boxDto.getItem())) {
                handleItems(box, boxDto.getItem());
            }

            if (!CollectionUtils.isEmpty(boxDto.getBox())) {
                handleBoxes(box, boxDto.getBox());
            }
        });
    }

    private void handleItems(final Box externalBox, final List<generated.Item> items) {
        items.forEach(itemDto -> {
            if (itemMap.containsKey(itemDto.getId())) {
                throw new ItemValidationException(itemDto.getId());
            }
            final Item item = itemMapper.toEntity(itemDto);
            item.setContainedIn(externalBox);
            itemMap.put(item.getId(), item);
        });
    }
}
